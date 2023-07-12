import { createSlice } from '@reduxjs/toolkit';

export const userSlice = createSlice({
  name: 'user',
  initialState: {
    user: []
  },
  reducers: {
    createUserAction: () => {},
    loginUserAction: () => {},
    getLogedUserAction: () => {},
    saveUserAction: (state, action) => {
      state.user = action.payload;
    },
    logoutUserAction: () => {}
  }
});

export const {
  createUserAction,
  loginUserAction,
  getLogedUserAction,
  saveUserAction,
  logoutUserAction
} = userSlice.actions;

//selectors
export const selectUser = (state) => state.userReducer.user;

//reducers
const userReducer = userSlice.reducer;
export default userReducer;
