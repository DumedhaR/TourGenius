import React from 'react';
import '../../utils/hotelContainer.css';
import HotelCard from './HotelCard';
import { useState } from 'react';
import IconButton from '@mui/material/IconButton';
import ArrowCircleLeftOutlinedIcon from '@mui/icons-material/ArrowCircleLeftOutlined';
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';

function HotelContainer({ topic, description, hotelData }) {
  const [activeIndex, setActiveIndex] = useState(0);
  const [displayedCards, setDisplayedCards] = useState(hotelData.slice(0, 3));

  const handleMoveLeft = () => {
    const newIndex = activeIndex - 1 < 0 ? 0 : activeIndex - 1;
    const newDisplayedCards = hotelData.slice(newIndex, newIndex + 3);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };

  const handleMoveRight = () => {
    const newIndex = activeIndex + 1 > hotelData.length - 3 ? activeIndex : activeIndex + 1;
    const newDisplayedCards = hotelData.slice(newIndex, newIndex + 3);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };
  return (
    <div>
      <h1 id="hotelTopic">{topic}</h1>
      <p id="hotelDescription">{description}</p>
      <div className="containerHotel">
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
          <div key={`hotelSriLanka-${index}`}>
            <HotelCard
              hotelName={element.hotelName}
              hotelImage={element.hotelImage}
              hotelRating={element.hotelRating}
              hotelCountry={element.hotelCountry}
              hotelDescription={element.hotelDescription}
              hotelDestination={element.hotelDestination}
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

export default HotelContainer;
