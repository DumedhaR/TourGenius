import React, { useState } from 'react';
import '../../utils/reviewFeedbacks.css';
// This Review data file remove when components are intergrated
import { ReviewData } from './reviewData';
import ReviewCard from './ReviewCard';
import Rating from '@mui/material/Rating';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import * as yup from 'yup';

function UserReviews() {
  const [ratingValue, setRatingValue] = useState(0);
  const initialValues = {
    userMessage: ''
  };

  const validationSchema = yup.object().shape({
    userMessage: yup.string().required('Required')
  });

  const onSubmit = (data) => {
    const name = 'New Name';
    const country = 'Country';
    const profilePicture = '';
    let rating = ratingValue;
    const userMessage = data.userMessage;

    const newReviewData = { name, country, profilePicture, rating, userMessage };
    console.log(newReviewData);

    setRatingValue(0);
    data.userMessage = '';
  };

  return (
    <div className="reviewContainer">
      <div className="reviewFeedbacks">
        {ReviewData.map((element, index) => (
          <div key={`review-${index}`}>
            <ReviewCard
              name={element.name}
              country={element.country}
              profilePicture={element.profilePicture}
              rating={element.rating}
              userMessage={element.userMessage}
            />
          </div>
        ))}
      </div>
      <div className="reviewForm">
        <Formik
          initialValues={initialValues}
          onSubmit={onSubmit}
          validationSchema={validationSchema}>
          <Form>
            <Rating
              name="simple-controlled"
              value={ratingValue}
              onChange={(event, newValue) => {
                setRatingValue(newValue);
              }}
            />
            <div>
              <Field
                as={TextField}
                name="userMessage"
                sx={{ width: '100%' }}
                label="Message"
                multiline
                rows={4}
                helperText={
                  <ErrorMessage
                    name="userMessage"
                    render={(msg) => <span id="errMsg">{msg}</span>}
                  />
                }
              />
            </div>
            <Button
              sx={{
                backgroundColor: 'green',
                borderRadius: '20px',
                marginTop: '10px',
                '&:hover': {
                  backgroundColor: '#00cc00'
                }
              }}
              variant="contained"
              type="submit">
              submit
            </Button>
          </Form>
        </Formik>
      </div>
    </div>
  );
}

export default UserReviews;
