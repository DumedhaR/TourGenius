import React from 'react';
import '../../utils/destinationContainer.css';
// This Destination data file remove when components are intergrated
import { DestinationData } from './destinationData';
import DestinationCard from './DestinationCard';
import { useState } from 'react';
import IconButton from '@mui/material/IconButton';
import ArrowCircleLeftOutlinedIcon from '@mui/icons-material/ArrowCircleLeftOutlined';
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';

function DestinationContainer() {
  const [activeIndex, setActiveIndex] = useState(0);
  const [displayedCards, setDisplayedCards] = useState(DestinationData.slice(0, 3));

  const handleMoveLeft = () => {
    const newIndex = activeIndex === 0 ? DestinationData.length - 1 : activeIndex - 1;
    const newDisplayedCards = DestinationData.slice(newIndex, newIndex + 3);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };

  const handleMoveRight = () => {
    const newIndex = activeIndex === DestinationData.length - 1 ? 0 : activeIndex + 1;
    const newDisplayedCards = DestinationData.slice(newIndex, newIndex + 3);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };
  return (
    <div>
      <h1 id="desTopic">Top destinations in Sri Lanka</h1>
      <p id="desDescription">explore most popular destination in Sri Lanka</p>
      <div className="containerDestination">
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
        {displayedCards.map((element, index) => (
          <div key={`desSriLanka-${index}`}>
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

export default DestinationContainer;
