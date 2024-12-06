import React, { useEffect, useState } from 'react';
import { DeleteTicket, Fetchget } from '../Service/Dservice';
import { Tab } from 'bootstrap';
import { useNavigate } from 'react-router-dom';

const Displayall = () => {
    // Create a constant variable for API connection with backend
    const [fetchall, setdetails] = useState([]);

    const navigate = useNavigate();

    useEffect(() => {
       getTicket();
    }, [])

    function getTicket(){
        Fetchget().then((response) => {
            setdetails(response.data);
        }).catch(error => {
            console.error(error);
        });
    }
    
    function bookticket(){
        navigate('/book-ticket')
    }

    function updateTicket(id){
        navigate(`/updateticket/${id}`);

    }

    function removeticket(id){
        console.log(id);
        DeleteTicket(id) .then((response) => {
            getTicket();
    }).catch(error => {
        console.error(error);
    })
}

    return (
        <div className='container max-width'>
            <h1>BusDetails</h1> 
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>seat</th>
                        <th>name</th>
                        <th>Bus name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {/* map function is important in it */}
                    {fetchall.map((detail) => (
                        <tr key={detail.id}>
                            <td>{detail.id}</td>
                            <td>{detail.seat}</td>
                            <td>{detail.pname}</td>
                            <td>{detail.bname}</td>
                            <td>
                            <button className='btn btn-primary' onClick={() => updateTicket(detail.id)} style={{ marginRight: '20px' }}>Update Ticket Info</button>
<button className='btn btn-danger' onClick={() => removeticket(detail.id)} style={{ marginLeft: '20px' }}>Delete</button>

                            </td>
                        </tr>
                        
                    ))}
                </tbody>
            </table>
             {/*mb-2 is for spacing below icon and the table*/}
             <div className="d-flex justify-content-start">
                <button type="button" className="btn btn-primary mb-2 mx-auto d-block" onClick={bookticket}>Book your Ticket</button>
                
            </div>
        </div>
    );
}

export default Displayall
