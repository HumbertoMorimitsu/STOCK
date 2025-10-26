import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/product";

const getAllProducts = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

export default { getAllProducts };
