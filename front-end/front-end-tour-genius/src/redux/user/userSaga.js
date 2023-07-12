import {
  createUserService,
  getLogedUserService,
  loginUserService,
  logoutUserService
} from '../../services/userService';
import {
  createUserAction,
  loginUserAction,
  saveUserAction,
  getLogedUserAction,
  logoutUserAction
} from './userSlice';

import { takeEvery, call, put } from 'redux-saga/effects';

function* registerUserGenerator({ payload }) {
  try {
    const responseCreate = yield call(createUserService, payload);
    if (responseCreate === 'Created') {
      alert('Registration Completed!');
      payload.navigate('/');
    } else {
      alert('Registration Failed! Please Enter Valid Details');
    }
  } catch (err) {
    console.log(err);
    alert('Registration Failed! Please Enter Valid Details');
  }
}

function* loginUserGenerator({ payload }) {
  try {
    const response = yield call(loginUserService, payload);
    if (response) {
      alert('Successfully Login');
      payload.navigate('/');
    } else {
      alert('Login Failed! Please Enter Valid Details');
    }
  } catch (err) {
    alert('Login Failed! Please Enter Valid Details');
  }
}

function* getLogedUserGenerator() {
  try {
    const response = yield call(getLogedUserService);
    yield put(saveUserAction(response));
  } catch (err) {
    console.log(err);
  }
}

function* logoutUserGenerator({ payload }) {
  try {
    const response = yield call(logoutUserService);
    if (response) {
      payload.navigate('/');
    } else {
      payload.navigate('/');
    }
  } catch (err) {
    console.log(err);
  }
}

function* allUsers() {
  yield takeEvery(createUserAction, registerUserGenerator);
  yield takeEvery(loginUserAction, loginUserGenerator);
  yield takeEvery(getLogedUserAction, getLogedUserGenerator);
  yield takeEvery(logoutUserAction, logoutUserGenerator);
}

export default allUsers;
