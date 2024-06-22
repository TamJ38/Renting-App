import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const AccommodationEdit = (props) => {
    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        name: "",
        category: 1,
        host: 1,
        numRooms: 2,
        isRented: "FREE"
    });

    useEffect(() => {
        if (props.accommodation) {
            updateFormData({
                name: props.accommodation.name || "",
                category: props.accommodation.category || 1,
                host: props.accommodation.host ? props.accommodation.host.id : 1,
                numRooms: props.accommodation.numRooms || 2,
                isRented: props.accommodation.isRented || "FREE"
            });
        }
    }, [props.accommodation]);

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const { name, category, host, numRooms, isRented } = formData;

        props.onEditAccommodation(props.accommodation.id, name, category, host, numRooms, isRented);
        navigate("/accommodations");
    };

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Accommodation name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               value={formData.name}
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" value={formData.category} onChange={handleChange}>
                            {props.categories.map((term) => (
                                <option key={term.id} value={term.id}>{term.valueOf()}</option>
                            ))}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Host</label>
                        <select name="host" className="form-control" value={formData.host} onChange={handleChange}>
                            {props.hosts.map((term) => (
                                <option key={term.id} value={term.id}>{term.name}</option>
                            ))}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="numRooms">Number of rooms</label>
                        <input type="text"
                               className="form-control"
                               id="numRooms"
                               name="numRooms"
                               value={formData.numRooms}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Rented or Free</label>
                        <input type="text"
                               className="form-control"
                               id="isRented"
                               name="isRented"
                               value={formData.isRented}
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    );
};

export default AccommodationEdit;
