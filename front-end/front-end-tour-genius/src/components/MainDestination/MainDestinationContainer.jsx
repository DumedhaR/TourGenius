import React from 'react';
import '../../utils/destinationContainer.css';
// This Destination data file remove when components are intergrated
import { DestinationData } from '../Destination/destinationData';
import DestinationCard from '../Destination/DestinationCard';
import { useState } from 'react';
import IconButton from '@mui/material/IconButton';
import ArrowCircleLeftOutlinedIcon from '@mui/icons-material/ArrowCircleLeftOutlined';
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';
import { TextField, MenuItem, FormControl, Select } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import '../../utils/mainDestinationContainer.css';

function MainDestinationContainer() {
  const [activeIndex, setActiveIndex] = useState(0);
  const [displayedCards, setDisplayedCards] = useState(DestinationData.slice(0, 3));
  const [searchCategory, setSearchCategory] = useState('destinationName');
  const [searchValue, setSearchValue] = useState('');

  const displayedCardElements = displayedCards.map((element, index) => (
    <div key={`mainDesFilter-${index}`}>
      <DestinationCard
        destinationName={element.destinationName}
        destinationImage={element.destinationImage}
        destinationRating={element.destinationRating}
        destinationCountry={element.destinationCountry}
        destinationDescription={element.destinationDescription}
      />
    </div>
  ));

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

  const handleSearchCategoryChange = (event) => {
    setSearchCategory(event.target.value);
  };

  const handleSearchValueChange = (event) => {
    setSearchValue(event.target.value);
  };

  const handleFilter = () => {
    const filteredData = DestinationData.filter((destination) =>
      destination[searchCategory].toLowerCase().includes(searchValue.toLowerCase())
    );
    setDisplayedCards(filteredData.slice(0, 3));
    setActiveIndex(0);
  };

  return (
    <div className="mainFilter">
      <div className="searchBarContainer">
        <FormControl sx={{ minWidth: 120, marginRight: '16px' }} variant="outlined">
          <Select
            labelId="search-category-label"
            id="search-category"
            value={searchCategory}
            onChange={handleSearchCategoryChange}
            className="searchSelect">
            <MenuItem value="destinationName">Destination Name</MenuItem>
            <MenuItem value="destinationCountry">Destination Country</MenuItem>
          </Select>
        </FormControl>
        <TextField
          id="search-value"
          label="Search"
          value={searchValue}
          onChange={handleSearchValueChange}
          variant="outlined"
          className="searchTextField"
        />
        <IconButton aria-label="search" onClick={handleFilter} className="searchButton">
          <SearchIcon />
        </IconButton>
      </div>

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
        {displayedCardElements}
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

export default MainDestinationContainer;
