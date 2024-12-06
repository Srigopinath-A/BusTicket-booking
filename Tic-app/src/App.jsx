import React from 'react'
import Displayall from './Component/Displayall'
import Headerfile from './Component/Headerfile'
import Footerfile from './Component/Footerfile'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Bookingticket from './Component/Bookingticket'


const App = () => {
  return (
    <   >
    
    <BrowserRouter>
    <Headerfile/>
    <Routes>
    
      <Route path="/" element={<Displayall/>}/>
      <Route path="/fetchall" element={<Displayall/>}/>
      <Route path="/book-ticket" element={<Bookingticket/>}/>
      <Route path= 'updateticket/:id' element={<Bookingticket/>} />
    </Routes>
    
    <Footerfile/>
    </BrowserRouter>
    </>
  )
}

export default App