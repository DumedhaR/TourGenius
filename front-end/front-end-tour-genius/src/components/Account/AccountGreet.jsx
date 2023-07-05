import React from 'react';
import Avatar from '@mui/material/Avatar';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import '../../utils/AccountGreet.css';
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme({
  palette: {
    primary: {
      main: '#FFFFFF',
      darker: '#4DA343',
      contrastText: '#4DA343'
    },
    secondary: {
      main: '#11cb5f'
    }
  }
});

function AccountGreet({ firstName, lastName, profilePicture }) {
  const handleEditProfile = () => {};
  return (
    <div className="user-details">
      <div className="profile-picture">
        <Stack direction="row" spacing={2}>
          <Avatar alt="Remy Sharp" src={profilePicture} sx={{ width: 90, height: 90 }} />
        </Stack>
      </div>
      <div className="greet-message">
        <div className="header1">
          Hello, {firstName} {lastName}
        </div>
        <div className="header2">You can manage your account here.</div>
      </div>
      <ThemeProvider theme={theme}>
        <Button variant="contained" onClick={handleEditProfile} color="primary">
          Edit Profile
        </Button>
      </ThemeProvider>
    </div>
  );
}
export default AccountGreet;
