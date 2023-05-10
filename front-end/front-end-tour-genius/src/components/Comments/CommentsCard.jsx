import React from 'react';
import '../../utils/commentsCard.css';
import quotation from '../../assests/images/quotation.png';
import Avatar from '@mui/material/Avatar';

function CommentsCard({ name, message, profilePicture }) {
  return (
    <div className="cardComments">
      <img src={quotation} width="40px" height="40px" />
      <div className="messageComments">{message}</div>
      <div className="userComments">
        <Avatar alt={name} src={profilePicture} />
        <div className="userNameComments">{name}</div>
      </div>
    </div>
  );
}

export default CommentsCard;
