import React from 'react';
import '../../utils/destinationContainer.css';
// This Destination data file remove when components are intergrated
import { MainDestinationData } from './mainDestinationData';
import MainDestinationCard from './MainDestinationCard';
import { useState } from 'react';
import IconButton from '@mui/material/IconButton';
import ArrowCircleLeftOutlinedIcon from '@mui/icons-material/ArrowCircleLeftOutlined';
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';
import { TextField, MenuItem, FormControl, Select, InputLabel } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import '../../utils/mainDestinationContainer.css';

function MainDestinationContainer() {
  const [activeIndex, setActiveIndex] = useState(0);
  const [displayedCards, setDisplayedCards] = useState(MainDestinationData.slice(0, 3));
  const [searchCategory, setSearchCategory] = useState('destinationName');
  const [searchValue, setSearchValue] = useState('');

  const handleMoveLeft = () => {
    const newIndex = activeIndex === 0 ? MainDestinationData.length - 1 : activeIndex - 1;
    const newDisplayedCards = MainDestinationData.slice(newIndex, newIndex + 3);
    setDisplayedCards(newDisplayedCards);
    setActiveIndex(newIndex);
  };

  const handleMoveRight = () => {
    const newIndex = activeIndex === MainDestinationData.length - 1 ? 0 : activeIndex + 1;
    const newDisplayedCards = MainDestinationData.slice(newIndex, newIndex + 3);
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
    const filteredData = MainDestinationData.filter((destination) =>
      destination[searchCategory].toLowerCase().includes(searchValue.toLowerCase())
    );
    setDisplayedCards(filteredData.slice(0, 3));
    setActiveIndex(0);
  };

  return (
    <div className="mainFilter">
      <div className="searchBarContainer">
          <FormControl sx={{ minWidth: 120, marginRight: '16px' }}>
            <InputLabel id="search-category-label">Search Category</InputLabel>
            <Select
              labelId="search-category-label"
              id="search-category"
              value={searchCategory}
              onChange={handleSearchCategoryChange}
            >
              <MenuItem value="destinationName">Destination Name</MenuItem>
              <MenuItem value="destinationCountry">Destination Country</MenuItem>
            </Select>
          </FormControl>
          <TextField
            id="search-value"
            label="Search Value"
            value={searchValue}
            onChange={handleSearchValueChange}
          />
          <IconButton aria-label="search" onClick={handleFilter}>
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
        {displayedCards.map((element,index)=>{
          return(
            <div key={`mainDesFilter-${index}`}>
            <MainDestinationCard
              destinationName={element.destinationName}
              destinationImage={element.destinationImage}
              destinationCountry={element.destinationCountry}
            />
          </div>
          )
        })}
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
