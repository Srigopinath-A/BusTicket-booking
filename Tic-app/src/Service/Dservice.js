import axios from "axios";

// no changes it will work fine 

const URL = "http://localhost:8080/api/booking"; // Define the URL for the API endpoint

export const Fetchget = () => axios.get(URL);

export const Savedetails = (details) => axios.post(URL,details);

export const GetTicket = (id) =>axios.get(URL +'/'+ id);

export const Updatedetails = (id, details) =>axios.put(URL +'/'+ id,details);

export const DeleteTicket = (id) =>axios.delete(URL +'/'+ id);