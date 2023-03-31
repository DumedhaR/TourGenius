import React from 'react';
import logo from '../../assests/images/logo.jpg';
import '../../utils/loginPage.css';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import * as yup from 'yup';
import { useNavigate } from 'react-router-dom';

function LoginPage() {
  const initialValues = {
    email: '',
    password: ''
  };

  const validationSchema = yup.object().shape({
    email: yup.string().email('Please Enter Valid Email').required('Required'),
    password: yup.string().required('Required')
  });

  const onSubmit = (data) => {
    const email = data.email.toLowerCase();
    const password = data.password;

    console.log('Email ', email);
    console.log('Password ', password);
  };

  const navigate = useNavigate();

  const navigateToRegister = () => {
    navigate('/register');
  };

  return (
    <div className="loginPage">
      <div className="loginForm">
        <div className="loginHeader">
          <img src={logo} width="50px" height="50px" />
          <h1 id="headerTopic">TourGenius</h1>
        </div>
        <div>
          <p id="welcome">Welcome Back!</p>
          <p id="signInTopic">Sign In</p>
        </div>
        <div className="formBody">
          <Formik
            initialValues={initialValues}
            onSubmit={onSubmit}
            validationSchema={validationSchema}>
            <Form>
              <Field
                as={TextField}
                sx={{ width: '100%' }}
                name="email"
                label="Email"
                variant="outlined"
                helperText={
                  <ErrorMessage name="email" render={(msg) => <span id="errMsg">{msg}</span>} />
                }
              />
              <Field
                as={TextField}
                sx={{ width: '100%', marginTop: '50px' }}
                name="password"
                label="Password"
                type={'password'}
                variant="outlined"
                helperText={
                  <ErrorMessage name="password" render={(msg) => <span id="errMsg">{msg}</span>} />
                }
              />
              <Button variant="contained" sx={{ width: '100%', marginTop: '50px' }} type="submit">
                sign in
              </Button>
            </Form>
          </Formik>
        </div>
        <div>
          <Button variant="text" sx={{ marginTop: '20px' }} onClick={navigateToRegister}>
            Create New Account
          </Button>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;
