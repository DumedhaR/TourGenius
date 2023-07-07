import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  destinations: [],
  loading: false,
  error: null
};

const destinationSlice = createSlice({
  name: 'destination',
  initialState,
  reducers: {
    addDestinationAction: (state) => {
      state.loading = true;
      state.error = null;
    },
    addDestinationSuccessAction: (state, action) => {
      state.loading = false;
      state.error = null;
      state.destinations.push(action.payload);
    },
    addDestinationFailureAction: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
    fetchDestinationsAction: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchDestinationsSuccessAction: (state, action) => {
      state.loading = false;
      state.error = null;
      state.destinations = action.payload;
    },
    fetchDestinationsFailureAction: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    }
  }
});

export const {
  addDestinationAction,
  addDestinationSuccessAction,
  addDestinationFailureAction,
  fetchDestinationsAction,
  fetchDestinationsSuccessAction,
  fetchDestinationsFailureAction
} = destinationSlice.actions;

export default destinationSlice.reducer;
