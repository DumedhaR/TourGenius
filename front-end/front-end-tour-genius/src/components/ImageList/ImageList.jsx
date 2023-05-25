import * as React from 'react';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';

function ImageContainer({ imageData }) {
  return (
    <ImageList sx={{ width: '100%', height: '450px' }} cols={6} rowHeight={222}>
      {imageData.map((item, index) => (
        <ImageListItem key={`image-${index}`}>
          <img
            src={`${item.destinationImageList}?w=164&h=164&fit=crop&auto=format`}
            srcSet={`${item.destinationImageList}?w=164&h=164&fit=crop&auto=format&dpr=2 2x`}
            loading="lazy"
          />
        </ImageListItem>
      ))}
    </ImageList>
  );
}

export default ImageContainer;
