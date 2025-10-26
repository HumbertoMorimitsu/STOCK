import { configureStore } from "@reduxjs/toolkit";
import productReducer from "../src/slice/HomeSlice";

export const store = configureStore({
  reducer: {
    products: productReducer,
  },
});
