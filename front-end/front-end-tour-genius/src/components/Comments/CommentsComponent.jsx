import React from 'react';
import '../../utils/commentsComponent.css';
import { useState } from 'react';
// This comments data file remove when components are intergrated
import { Commentsdata } from './commentsData';
import CommentsCard from './CommentsCard';
import IconButton from '@mui/material/IconButton';
import ArrowCircleLeftOutlinedIcon from '@mui/icons-material/ArrowCircleLeftOutlined';
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';

function CommentsComponent() {
  const [activeIndex, setActiveIndex] = useState(0);
  const [displayedCards, setDisplayedCards] = useState(Commentsdata.slice(0, 3));

  const handleMoveLeft = () => {
    const newIndex = activeIndex === 0 ? Commentsdata.length - 1 : activeIndex - 1;
    const newDisplayedCards = Commentsdata.slice(newIndex, newIndex + 3);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };

  const handleMoveRight = () => {
    const newIndex = activeIndex === Commentsdata.length - 1 ? 0 : activeIndex + 1;
    const newDisplayedCards = Commentsdata.slice(newIndex, newIndex + 3);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };
  return (
    <div>
      <h1 id="commentsTopic">Comments from our users:</h1>
      <div className="commentsContainer">
        <IconButton aria-label="left" size="large" onClick={handleMoveLeft}>
          <ArrowCircleLeftOutlinedIcon
            sx={{
              width: '100px',
              height: '100px',
              '&:hover': {
                color: '#00cc00'
              }
            }}
            fontSize="inherit"
          />
        </IconButton>
        {displayedCards.map((element, index) => (
          <div key={`comments-${index}`}>
            <CommentsCard
              name={element.name}
              message={element.message}
              profilePicture={element.profilePicture}
              isActive={index === activeIndex}
            />
          </div>
        ))}
        <IconButton aria-label="left" size="large" onClick={handleMoveRight}>
          <ArrowCircleRightOutlinedIcon
            sx={{
              width: '100px',
              height: '100px',
              '&:hover': {
                color: '#00cc00'
              }
            }}
            fontSize="inherit"
          />
        </IconButton>
      </div>
    </div>
  );
}

export default CommentsComponent;
