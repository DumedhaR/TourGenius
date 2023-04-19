import React from 'react';
import '../../utils/commentsCard.css';
import quotation from '../../assests/images/quotation.png';
import Avatar from '@mui/material/Avatar';

function CommentsCard({ data }) {
  return (
    <div>
      {data.map((element, index) => (
        <div className="card" key={`card-${index}`}>
          <img src={quotation} width="40px" height="40px" />
          <div className="message">{element.message}</div>
          <div className="user">
            <Avatar alt={element.name} src={element.profilePicture} />
            <div className="userName">{element.name}</div>
          </div>
        </div>
      ))}
    </div>
  );
}

export default CommentsCard;
