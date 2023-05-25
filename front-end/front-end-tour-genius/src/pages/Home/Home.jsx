import React from 'react';
import NavigationBar from '../../components/Navigation/NavigationBar';
import '../../utils/homePage.css';
import Button from '@mui/material/Button';
import Footer from '../../components/Footer/Footer';
import { useNavigate } from 'react-router-dom';
import FeedbackForm from '../../components/Feedback/FeedbackForm';
import CommentsComponent from '../../components/Comments/CommentsComponent';
import DestinationContainer from '../../components/Destination/DestinationConiner';
import HotelContainer from '../../components/Hotel/HotelContainer';
// This Hotel data file remove when components are intergrated
import { HotelData } from '../../components/Hotel/hotelData';

function HomePage() {
  const navigate = useNavigate();

  const navigateToSignIn = () => {
    navigate('/signIn');
  };
  return (
    <div className="home">
      <div className="navigation">
        <NavigationBar />
      </div>
      <div className="homeHeader">
        <div className="headerContent">
          <h1 id="homeTopic">TourGeniuz</h1>
          <p id="homeDescription">
            We will help you to find best travel destination cross the world as your preference
          </p>
          <Button
            variant="contained"
            sx={{
              width: '200px',
              backgroundColor: 'green',
              borderRadius: '20px',
              display: 'flex',
              margin: 'auto',
              marginTop: '75px',
              '&:hover': {
                backgroundColor: '#00cc00'
              }
            }}>
            EXPLORE NOW
          </Button>
        </div>
      </div>

      {/* destination filter have to add*/}

      <div className="destinationHome">
        <DestinationContainer />
      </div>
      <div className="hotelHome">
        <HotelContainer
          topic="Meet our top clients"
          description="explore best hotels, restaurant and spas in Sri Lanka"
          hotelData={HotelData}
        />
      </div>
      <div className="signup">
        <div className="signupImage"></div>
        <div className="signupContent">
          <p id="contentDescription">Join with us to get personalized travel experience.</p>
          <p id="joinTourGeniuz">Join TourGeniuz now!</p>
          <Button
            variant="contained"
            sx={{
              width: '200px',
              backgroundColor: '#ffffff',
              color: 'green',
              borderRadius: '20px',
              marginTop: '20px',
              '&:hover': {
                backgroundColor: '#f5f5f5'
              }
            }}
            onClick={navigateToSignIn}>
            SIGN ME UP
          </Button>
        </div>
      </div>
      <div className="commentsHome">
        <CommentsComponent />
      </div>
      <div className="feedback">
        <FeedbackForm />
      </div>
      <div className="footerHome">
        <Footer />
      </div>
    </div>
  );
}

export default HomePage;
