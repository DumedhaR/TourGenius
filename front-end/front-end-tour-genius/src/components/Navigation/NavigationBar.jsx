import React from 'react';
import '../../utils/navigationBar.css';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { useNavigate } from 'react-router-dom';

function Navigation() {
  const navigate = useNavigate();
  // userEmail gain from the database when components are integrated
  const userEmail = 'user@gmail.com';
  const navigateToHome = () => {
    navigate('/');
  };
  const navigateToAboutUs = () => {
    navigate('/aboutUs');
  };
  const navigateToContactUs = () => {
    navigate('/contactUs');
  };
  const signInSignOut = () => {
    if (!userEmail) {
      navigate('/signIn');
    } else {
      navigate('/');
    }
  };
  const navigateToProfile = () => {
    navigate('/account/traveler');
  };
  return (
    <div className="navBar">
      <div className="pages">
        <Stack spacing={2} direction="row">
          <Button
            variant="text"
            sx={{
              textTransform: 'none',
              color: 'black'
            }}
            onClick={navigateToHome}>
            Home
          </Button>
          <Button
            variant="text"
            sx={{ textTransform: 'none', color: 'black' }}
            onClick={navigateToAboutUs}>
            About Us
          </Button>
          <Button
            variant="text"
            sx={{ textTransform: 'none', color: 'black' }}
            onClick={navigateToContactUs}>
            Contact Us
          </Button>
        </Stack>
      </div>
      <div className="userOptions">
        {userEmail && (
          <IconButton sx={{ marginRight: '10px' }} onClick={navigateToProfile}>
            <AccountCircleIcon />
          </IconButton>
        )}
        <Button
          variant="contained"
          sx={{
            textTransform: 'none',
            backgroundColor: '#008000',
            '&:hover': {
              backgroundColor: '#00cc00'
            }
          }}
          onClick={signInSignOut}>
          {userEmail ? 'Sign Out' : 'sign In'}
        </Button>
      </div>
    </div>
  );
}

export default Navigation;
