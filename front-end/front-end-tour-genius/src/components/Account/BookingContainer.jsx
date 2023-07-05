import React from 'react';
import { useState } from 'react';
import IconButton from '@mui/material/IconButton';
import ArrowCircleLeftOutlinedIcon from '@mui/icons-material/ArrowCircleLeftOutlined';
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';
import BookingCard from './BookingCard';
import { BookingData } from './BookingData';
//import Typography from '@mui/material/Typography';
import '../../utils/BookingContainer.css';

function BookingContainer() {
  const [activeIndex, setActiveIndex] = useState(0);
  const [displayedCards, setDisplayedCards] = useState(BookingData.slice(0, 4));

  const handleMoveLeft = () => {
    const newIndex = activeIndex - 1 < 0 ? 0 : activeIndex - 1;
    const newDisplayedCards = BookingData.slice(newIndex, newIndex + 4);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };

  const handleMoveRight = () => {
    const newIndex = activeIndex + 1 > BookingData.length - 4 ? activeIndex : activeIndex + 1;
    const newDisplayedCards = BookingData.slice(newIndex, newIndex + 4);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };
  return (
    <div>
      <div id="Topic">Upcoming Bookings</div>
      <div className="containerBooking">
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
            <BookingCard
              clientName={element.clientName}
              packageName={element.packageName}
              totalRooms={element.totalRooms}
              payment={element.payment}
              checkInDate={element.checkInDate}
              checkOutDate={element.checkOutDate}
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

export default BookingContainer;
