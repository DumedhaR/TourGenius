import React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Rating from '@mui/material/Rating';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function DestinationCard({
  destinationName,
  destinationImage,
  destinationRating,
  destinationCountry,
  destinationDescription
}) {
  const [showMore, setShowMore] = useState(false);
  const navigate = useNavigate();

  const navigateToDestination = () => {
    navigate(`/destination/${destinationName}`);
  };
  return (
    <div className="cardDestination">
      <Card sx={{ maxWidth: 345 }}>
        <CardMedia
          component="img"
          alt={destinationName}
          height="200px"
          image={destinationImage}
          onClick={navigateToDestination}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {destinationName}
          </Typography>
          <div className="rating" style={{ display: 'flex' }}>
            <Rating name="read-only" value={destinationRating} readOnly />
            <Typography
              sx={{ marginLeft: '10px', marginTop: '-5px' }}
              gutterBottom
              variant="h6"
              component="div">
              {destinationRating}
            </Typography>
          </div>
          <Typography gutterBottom variant="h7" component="div">
            Situated in {destinationCountry}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {showMore
              ? destinationDescription
              : destinationDescription && destinationDescription.substring(0, 100)}
          </Typography>
        </CardContent>
        {destinationDescription.length >= 100 && (
          <CardActions>
            <Button size="small" onClick={() => setShowMore(!showMore)}>
              {!showMore ? 'show more' : 'show less'}
            </Button>
            <Button size="small" onClick={navigateToDestination}>
              visit
            </Button>
          </CardActions>
        )}
      </Card>
    </div>
  );
}

export default DestinationCard;
