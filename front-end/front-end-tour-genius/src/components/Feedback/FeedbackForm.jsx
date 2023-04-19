import React from 'react';
import '../../utils/feedbackForm.css';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import * as yup from 'yup';

function FeedbackForm() {
  const initialValues = {
    name: '',
    email: '',
    message: ''
  };

  const validationSchema = yup.object().shape({
    name: yup.string().required('Required'),
    email: yup.string().email('Please Enter Valid Email').required('Required'),
    message: yup.string().required('Required')
  });

  const onSubmit = (data) => {
    const name = data.name;
    const email = data.email.toLowerCase();
    const message = data.message;

    console.log('Name', name);
    console.log('Email ', email);
    console.log('Message ', message);
  };
  return (
    <div className="feedbackForm">
      <div className="content">
        <p>Send us your thoughts about us...</p>
      </div>
      <div className="form">
        <Formik
          initialValues={initialValues}
          onSubmit={onSubmit}
          validationSchema={validationSchema}>
          <Form>
            <Field
              as={TextField}
              name="name"
              sx={{ width: '100%' }}
              label="name"
              variant="filled"
              InputProps={{
                disableUnderline: true,
                style: {
                  backgroundColor: 'white',
                  borderRadius: '20px'
                }
              }}
              helperText={
                <ErrorMessage name="name" render={(msg) => <span id="errMsg">{msg}</span>} />
              }
            />
            <Field
              as={TextField}
              name="email"
              sx={{
                width: '100%',
                marginTop: '25px'
              }}
              label="email"
              variant="filled"
              InputProps={{
                disableUnderline: true,
                style: {
                  backgroundColor: 'white',
                  borderRadius: '20px'
                }
              }}
              helperText={
                <ErrorMessage name="email" render={(msg) => <span id="errMsg">{msg}</span>} />
              }
            />
            <Field
              as={TextField}
              name="message"
              sx={{
                width: '100%',
                marginTop: '25px'
              }}
              label="message"
              variant="filled"
              InputProps={{
                disableUnderline: true,
                style: {
                  backgroundColor: 'white',
                  borderRadius: '20px'
                }
              }}
              multiline
              maxRows={4}
              helperText={
                <ErrorMessage name="message" render={(msg) => <span id="errMsg">{msg}</span>} />
              }
            />
            <Button
              sx={{ float: 'right', marginTop: '40px', borderRadius: '20px' }}
              variant="contained"
              type="submit"
              color="success"
              size="large">
              submit
            </Button>
          </Form>
        </Formik>
      </div>
    </div>
  );
}

export default FeedbackForm;
