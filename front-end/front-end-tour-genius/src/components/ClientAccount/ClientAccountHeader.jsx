import React from 'react';
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

function ClientAccountHeader({ firstName, lastName, propertyName }) {
  const handleEditProfile = () => {};
  return (
    <div className="user-details">
      <div className="greet-message">
        <div className="header1">{propertyName}</div>
        <div className="header2">
          Hello, {firstName} {lastName}
        </div>
      </div>
      <ThemeProvider theme={theme}>
        <Button variant="contained" onClick={handleEditProfile} color="primary">
          Edit Profile
        </Button>
      </ThemeProvider>
    </div>
  );
}
export default ClientAccountHeader;
