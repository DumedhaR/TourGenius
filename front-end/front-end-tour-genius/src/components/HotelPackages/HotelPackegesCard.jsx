import React from 'react';
import '../../utils/hotelPackageCard.css';
import Typography from '@mui/material/Typography';
import Rating from '@mui/material/Rating';
import Button from '@mui/material/Button';
import { useNavigate } from 'react-router-dom';

function PackagesCard({
  packageImage,
  packageName,
  packageRating,
  packageDescription,
  packageInclude,
  availableRooms,
  packagePrize
}) {
  const navigate = useNavigate();
  const navigatetoReservation = () => {
    navigate(`/reservation/${packageName}`);
  };
  return (
    <div className="hotelPackageCard">
      <div className="packageImage">
        <img src={packageImage} width="100%" height="100%" />
      </div>
      <div className="packageContent">
        <div className="explainPackage">
          <Typography variant="h6" gutterBottom>
            {packageName}
          </Typography>
          <Rating sx={{ marginTop: '-10px' }} name="read-only" value={packageRating} readOnly />
          <Typography sx={{ marginTop: '10px' }} variant="body2" gutterBottom>
            {packageDescription}
          </Typography>
          <div className="packageInclude">
            {packageInclude.map((item, index) => (
              <Typography
                key={`packageInclude-${index}`}
                sx={{ fontWeight: 'bold', fontSize: '8pt', lineHeight: 1 }}
                variant="subtitle2"
                gutterBottom>
                {item}
              </Typography>
            ))}
          </div>
        </div>
        <div className="bookPackage">
          <div className="packageAvailability">
            <Typography sx={{ color: 'green' }} variant="h5" gutterBottom>
              {availableRooms}
            </Typography>
            <Typography
              sx={{ fontWeight: 'bold', marginTop: '-15px' }}
              variant="subtitle2"
              gutterBottom>
              Rooms Left
            </Typography>
          </div>
          <div className="packagePrize">
            <Typography sx={{ color: 'green' }} variant="h5" gutterBottom>
              {packagePrize}$
            </Typography>
            <Typography
              sx={{ fontWeight: 'bold', marginTop: '-15px' }}
              variant="subtitle2"
              gutterBottom>
              Per Night
            </Typography>
          </div>
          <Button
            sx={{
              backgroundColor: 'green',
              marginTop: '25px',
              '&:hover': {
                backgroundColor: '#00cc00'
              },
              textTransform: 'none'
            }}
            variant="contained"
            onClick={navigatetoReservation}
            disabled={availableRooms === 0}>
            Book Now
          </Button>
        </div>
      </div>
    </div>
  );
}

export default PackagesCard;
