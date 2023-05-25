import React from 'react';
import '../../utils/nearSimilarDestination.css';
import DestinationCard from './DestinationCard';
import { useState } from 'react';
import IconButton from '@mui/material/IconButton';
import ArrowCircleLeftOutlinedIcon from '@mui/icons-material/ArrowCircleLeftOutlined';
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';

function NearSimilarPlacesContainer({ desPlaceTopic, destinationData }) {
  let data;
  if (destinationData) {
    data = destinationData.slice(0, 1);
  }

  const [activeIndex, setActiveIndex] = useState(0);
  const [displayedCards, setDisplayedCards] = useState(data);

  const handleMoveLeft = () => {
    if (destinationData) {
      const newIndex = activeIndex === 0 ? destinationData.length - 1 : activeIndex - 1;
      const newDisplayedCards = destinationData.slice(newIndex, newIndex + 1);
      setDisplayedCards(newDisplayedCards);
      setActiveIndex(newIndex);
    }
  };

  const handleMoveRight = () => {
    if (destinationData) {
      const newIndex = activeIndex === destinationData.length - 1 ? 0 : activeIndex + 1;
      const newDisplayedCards = destinationData.slice(newIndex, newIndex + 1);
      setDisplayedCards(newDisplayedCards);
      setActiveIndex(newIndex);
    }
  };

  return (
    <div>
      <h2 id="desNearSimilarTopic">{desPlaceTopic}</h2>
      <div className="containerNearSimilarDestination">
        <IconButton aria-label="left" size="large" onClick={handleMoveLeft}>
          <ArrowCircleLeftOutlinedIcon
            sx={{
              width: '50px',
              height: '50px',
              '&:hover': {
                color: '#00cc00'
              }
            }}
            fontSize="inherit"
          />
        </IconButton>
        {data &&
          displayedCards.map((element, index) => (
            <div key={`desNearSimilar-${index}`}>
              <DestinationCard
                destinationName={element.destinationName}
                destinationImage={element.destinationImage}
                destinationRating={element.destinationRating}
                destinationCountry={element.destinationCountry}
                destinationDescription={element.destinationDescription}
              />
            </div>
          ))}
        <IconButton aria-label="left" size="large" onClick={handleMoveRight}>
          <ArrowCircleRightOutlinedIcon
            sx={{
              width: '50px',
              height: '50px',
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

export default NearSimilarPlacesContainer;
