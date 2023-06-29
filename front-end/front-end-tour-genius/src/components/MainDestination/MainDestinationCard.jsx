import React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { useNavigate } from 'react-router-dom';

function MainDestination({ destinationName, destinationImage, destinationCountry }) {
  const navigate = useNavigate();

  const navigateToDestination = () => {
    navigate(`/destination/${destinationName}`);
  };
  return (
    <div className="cardDestination">
      <Card sx={{ maxWidth: 345 }} onClick={navigateToDestination}  >
        <CardMedia component="img" alt={destinationName} height="200px" image={destinationImage} />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {destinationName}
          </Typography>
          <div className="rating" style={{ display: 'flex' }}>
            <Typography
              sx={{ marginLeft: '10px', marginTop: '-5px' }}
              gutterBottom
              variant="h6"
              component="div"></Typography>
          </div>
          <Typography gutterBottom variant="h7" component="div">
            Situated in {destinationCountry}
          </Typography>
        </CardContent>
      </Card>
    </div>
  );
}

export default MainDestination;
