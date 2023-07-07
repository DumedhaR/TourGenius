import axios from 'axios';

export const registerUserService = async (user) => {
  const userData = {
    email: user.email,
    password: user.password
  };
  try {
    const responseData = await axios.post('http://localhost:9001/account/register', userData);
    return responseData;
  } catch (err) {
    console.log(err);
  }
};

export const createUserService = async (user) => {
  const userData = {
    email: user.email,
    firstName: user.firstName,
    lastName: user.lastName,
    dateOfBirth: user.dateOfBirth,
    country: user.country
  };
  try {
    const response = await axios.post('http://localhost:9001/traveler/create', userData, {
      withCredentials: true
    });
    return response;
  } catch (err) {
    console.log(err);
  }
};

export const loginUserService = async (user) => {
  const userData = {
    email: user.email,
    password: user.password
  };
  try {
    const response = await axios.post('http://localhost:9001/account/auth', userData, {
      withCredentials: true
    });
    return response;
  } catch (err) {
    console.log(err);
  }
};

export const getLogedUserService = async () => {
  try {
    const response = await axios.get('http://localhost:9001/account/get', {
      withCredentials: true
    });
    return response;
  } catch (err) {
    console.log(err);
  }
};

export const logoutUserService = async () => {
  try {
    const responseData = await axios.get('http://localhost:9001/account/logOut', {
      withCredentials: true
    });
    return responseData;
  } catch (err) {
    console.log(err);
  }
};
