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

function HotelCard({
  hotelName,
  hotelImage,
  hotelRating,
  hotelCountry,
  hotelDestination,
  hotelDescription
}) {
  const [showMore, setShowMore] = useState(false);
  const navigate = useNavigate();

  const navigateToHotel = () => {
    navigate(`/hotel/${hotelName}`);
  };
  return (
    <div className="cardHotel">
      <Card sx={{ maxWidth: 345 }}>
        <CardMedia
          component="img"
          alt={hotelName}
          height="200px"
          image={hotelImage}
          onClick={navigateToHotel}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {hotelName}
          </Typography>
          <div className="rating" style={{ display: 'flex' }}>
            <Rating name="read-only" value={hotelRating} readOnly />
            <Typography
              sx={{ marginLeft: '10px', marginTop: '-5px' }}
              gutterBottom
              variant="h6"
              component="div">
              {hotelRating}
            </Typography>
          </div>
          <Typography gutterBottom variant="h7" component="div">
            Hotel in{' '}
            <b>
              {hotelDestination} {hotelCountry}
            </b>
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {showMore ? hotelDescription : hotelDescription && hotelDescription.substring(0, 100)}
          </Typography>
        </CardContent>
        {hotelDescription.length >= 100 && (
          <CardActions>
            <Button size="small" onClick={() => setShowMore(!showMore)}>
              {!showMore ? 'show more' : 'show less'}
            </Button>
            <Button size="small" onClick={navigateToHotel}>
              visit
            </Button>
          </CardActions>
        )}
      </Card>
    </div>
  );
}

export default HotelCard;
