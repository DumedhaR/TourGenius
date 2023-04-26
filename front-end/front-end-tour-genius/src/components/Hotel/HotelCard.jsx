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

function HotelCard({ data }) {
  const [showMore, setShowMore] = useState(false);
  const navigate = useNavigate();

  const navigateToHotel = () => {
    navigate();
  };
  return (
    <div>
      {data.map((element, index) => (
        <div className="card" key={`hotelCard-${index}`}>
          <Card sx={{ maxWidth: 345 }}>
            <CardMedia
              component="img"
              alt={element.hotelName}
              height="200px"
              image={element.hotelImage}
              onClick={navigateToHotel}
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                {element.hotelName}
              </Typography>
              <div className="rating" style={{ display: 'flex' }}>
                <Rating name="read-only" value={element.hotelRating} readOnly />
                <Typography
                  sx={{ marginLeft: '10px', marginTop: '-5px' }}
                  gutterBottom
                  variant="h6"
                  component="div">
                  {element.hotelRating}
                </Typography>
              </div>
              <Typography gutterBottom variant="h7" component="div">
                Hotel in{' '}
                <b>
                  {element.hotelDestination} {element.hotelCountry}
                </b>
              </Typography>
              <Typography variant="body2" color="text.secondary">
                {showMore
                  ? element.hotelDescription
                  : element.hotelDescription && element.hotelDescription.substring(0, 100)}
              </Typography>
            </CardContent>
            {element.hotelDescription.length >= 100 && (
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
      ))}
    </div>
  );
}

export default HotelCard;
