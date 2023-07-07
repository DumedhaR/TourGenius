import { takeEvery, call, put } from 'redux-saga/effects';
import { addDestination } from '../../services/destinationService';
import {
  addDestinationAction,
  fetchDestinationsAction,
  fetchDestinationsSuccessAction
} from '../destination/destinationSlice';

function* addDestinationGenerator({ payload }) {
  try {
    const response = yield call(addDestination, payload);
    if (response) {
      alert('Destination added successfully');
      yield put(fetchDestinationsAction());
    } else {
      alert('Failed to add destination');
    }
  } catch (err) {
    console.log(err);
    alert('Failed to add destination');
  }
}

function* fetchDestinationsGenerator() {
  try {
    const response = yield call(fetchDestinations);

    yield put(fetchDestinationsSuccessAction(response));
  } catch (err) {
    console.log(err);
  }
}

function* destinationSaga() {
  yield takeEvery(addDestinationAction, addDestinationGenerator);
  yield takeEvery(fetchDestinationsAction, fetchDestinationsGenerator);
}

export default destinationSaga;
