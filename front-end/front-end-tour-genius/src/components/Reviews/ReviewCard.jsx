import React from 'react';
import '../../utils/userReviews.css';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import Rating from '@mui/material/Rating';

function ReviewCard({ name, country, profilePicture, rating, userMessage }) {
  return (
    <div className="travelersComments">
      <Avatar alt={name} src={profilePicture} sx={{ width: '50px', height: '50px' }} />
      <div className="reviewsUser">
        <Typography variant="h6" gutterBottom>
          {name}
        </Typography>
        <Typography
          sx={{ color: 'green', fontWeight: 'bold', marginTop: '-8px' }}
          variant="subtitle2"
          gutterBottom>
          {country}
        </Typography>
        <Rating name="read-only" value={rating} readOnly />
        <Typography variant="body2" gutterBottom>
          {userMessage}
        </Typography>
      </div>
    </div>
  );
}

export default ReviewCard;
