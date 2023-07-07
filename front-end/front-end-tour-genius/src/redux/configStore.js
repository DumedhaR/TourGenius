import { configureStore } from '@reduxjs/toolkit';
import userReducer from '../redux/user/userSlice';
import createSagaMiddleware from 'redux-saga';
import rootSaga from './rootSaga';

const saga = createSagaMiddleware();

const store = configureStore({
  reducer: {
    userReducer: userReducer
  },
  middleware: [saga]
});

saga.run(rootSaga);

export default store;
