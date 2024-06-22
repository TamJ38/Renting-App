import axios from "../custom-axios/axios";

const websiteService = {

    fetchAccommodations: () => {
        return axios.get("/accommodations");
        // .then((response) => {
        //                 console.log("Accommodations data:", response.data);
        //                 return response.data; // Return the data to the caller
        //             })
        //             .catch((error) => {
        //                 console.error("Error fetching accommodations:", error);
        //                 throw error; // Re-throw the error to be handled by the caller
        //             });
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchHosts: () => {
        return axios.get("/hosts");
    },
    deleteAccommodation: (id) => {
        return axios.delete(`/accommodations/delete/${id}`);
    },
    addAccommodation: (name, category, host, numRooms, isRented) => {
        return axios.post("/accommodations/add", {
            "name": name,
            "category": category,
            "host": host,
            "numRooms": numRooms,
            "isRented": isRented

        });
    },
    editAccommodation: (id, name, category, host, numRooms, isRented) => {
        return axios.put(`/accommodations/edit/${id}`, {
            "name": name,
            "category": category,
            "host": host,
            "numRooms": numRooms,
            "isRented": isRented
        });
    },
    getAccommodation: (id) => {
        return axios.get(`/accommodations/${id}`);
    },
    rentAccommodation: (id) => {
        return axios.post(`/accommodations/mark/${id}`);
    }

}
export default websiteService;