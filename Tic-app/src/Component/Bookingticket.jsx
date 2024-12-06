import React, { useEffect, useState } from 'react'
import { GetTicket, Savedetails} from '../Service/Dservice'
import { useNavigate, useParams} from 'react-router-dom'
import { Updatedetails } from '../Service/Dservice'



const Bookingticket = () => {

    const [seat, setseat] = useState('')
    const [pname, setpname] = useState('')
    const [bname, setbname] = useState('')

    const {id} = useParams();


    const[error,  seterror] = useState({
        seat: "",
        pname: "",
        bname: ""
    })

    const navigate = useNavigate();

    useEffect(()=> {

        if(id){
            GetTicket(id).then((response) =>{
                setseat(response.data.seat);
                setpname(response.data.pname);
                setbname(response.data.bname);
            }).catch(error => {
                console.error(error); // we dont need console log we need console error
            })
        }
    }, [id])

    function saveTicket(e){
        e.preventDefault();

        if(validation()){
            const details = {seat, pname, bname }
            console.log(details);

            if (id){
                Updatedetails(id,details).then((response) => {
                    console.log(response.data);
                    navigate('/fetchall')
                }
                ).catch(error => {
                    console.error(error);
                })
            } else{
                Savedetails(details).then((response) => {
                    console.log(response.data);
                    navigate('/fetchall')
                }) .catch(error => {
                     console.error(error);
                })
            }
            
        }

       

    }

    function validation(){
        let valid = true;
        const ecopy = {...error}


        if (typeof seat === 'number' && !isNaN(seat)){
            ecopy.seat = "";
        }else{
            ecopy.seat = "Please enter seat number";
            valid = false;
        }

        if(pname.trim()){
            ecopy.pname = "";
        }else{
            ecopy.pname = "Please enter seat number";
            valid = false;
        }

        if(bname.trim()){
            ecopy.bname = "";
        }else{
            ecopy.bname = "Please enter seat number";
            valid = false;
        }

        seterror (ecopy);
        return valid;
    
    }

    function Modifi(){
        if(id){
            return <h1 className='text-center'>update your ticket</h1>
        } else{
            return <h1 className='text-center'>Enter the details</h1>
        }
    }


    function Modifi2(){
        if(id){
            return <button  className='btn btn-primary mx-auto d-block text-center' onClick={saveTicket}> update ticket </button>
        } else{
            return <button  className='btn btn-primary mx-auto d-block text-center' onClick={saveTicket}> create ticket </button>
        }
    }

  return (
    <div className='conatiner mb-5'>
        <br />
    <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'> 

            {/* in this we gonna remove the h2 in order to use same form for add and update thats why we using the function Modifi
            <h1 className='text-center'>Enter the details</h1> */}
            {
                Modifi()
            }
            <div className='card-body'>
                <form >
                    <div className='form-group mb-2'>
                    <label className='form-label' >Seat Number:</label>
                    <input 
                    type='number' 
                    placeholder='Enter ur seat no'
                    name='seat'
                    value={seat}
                    className={`form-control ${error.seat ? 'is-invalid' : ''}`}
                    onChange={(e) =>  setseat(e.target.value)} />
                    {error.seat && <div className='invalid-feedback'>{error.seat}</div>}
                    </div>


                    <div className='form-group mb-2'>
                    <label className='form-label' >Passenger Name</label>
                    <input 
                    type='text' 
                    placeholder='Enter your name'
                    name='pname'
                    value={pname}
                    className= {`form-control ${error.pname ? 'is-invalid' : ''}`}
                    onChange={(e) => setpname(e.target.value)} />
                    {error.seat && <div className='invalid-feedback'>{error.pname}</div>}
                    </div>


                    <div className='form-group mb-2'>
                    <label className='form-label' >Bus Name</label>
                    <input 
                    type='text' 
                    placeholder='Enter bus you want'
                    name='bame'
                    value={bname}
                    className= {`form-control ${error.bname ? 'is-invalid' : ''}`}
                    onChange={(e) => setbname(e.target.value)} />
                    {error.seat && <div className='invalid-feedback'>{error.bname}</div>}
                    </div>

                    <br/>
                    <div>
                     { Modifi2() }
                    </div>  
                </form>
            </div>
        </div>

    </div>
    </div>
  )
}

export default Bookingticket