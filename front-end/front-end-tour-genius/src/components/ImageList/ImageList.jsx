import * as React from 'react';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
// This imageData file is removed when components are intergrated
import { imageData } from './imageData';

function ImageContainer() {
  return (
    <ImageList sx={{ width: '100%', height: '450px' }} cols={6} rowHeight={'fit-content'}>
      {imageData.map((item) => (
        <ImageListItem key={item.destinationImageList}>
          <img
            src={`${item.destinationImageList}?w=164&h=164&fit=crop&auto=format`}
            srcSet={`${item.destinationImageList}?w=164&h=164&fit=crop&auto=format&dpr=2 2x`}
            alt={item.destinationName}
            loading="lazy"
          />
        </ImageListItem>
      ))}
    </ImageList>
  );
}

export default ImageContainer;
