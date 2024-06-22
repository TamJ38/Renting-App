// import logo from '../../logo.svg';
import './App.css';
import React, {Component} from "react";
import Accommodations from "../Accommodations/AccommodationList/accommodations";
import websiteService from "../../repository/websiteRepository";
import {BrowserRouter as Router, Navigate, Redirect, Route, Routes} from 'react-router-dom'
import Categories from "../Categories/categories";
import Hosts from "../Hosts/hosts";
import Header from '../Header/header';
import websiteRepository from "../../repository/websiteRepository";
import AccommodationAdd from "../Accommodations/AccommodationAdd/accommodationAdd";
import AccommodationEdit from "../Accommodations/AccommodationEdit/accommodationEdit";

class App extends Component{
  constructor(props) {
    super(props);
    this.state = {
      accommodations:[],
        categories:[],
        hosts:[],
        selectedAccommodation: {}

    }
  }

  render() {

    return(
        <div>
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                        <Route path={"/accommodations"} element={<Accommodations accommodations={this.state.accommodations}
                                                                                 onDelete={this.deleteAccommodation}
                                                                                 onEdit={this.getAccommodation}
                                                                                 onRent={this.rentAccommodation}
                        />} />
                        <Route path={"/categories"} element={<Categories categories={this.state.categories}/>}/>
                        <Route path={"/hosts"} element={<Hosts hosts={this.state.hosts}/>}/>
                            <Route path={"/accommodations/add"} element={
                                <AccommodationAdd categories={this.state.categories}
                                            hosts={this.state.hosts}
                                            onAddAccommodation={this.addAccommodation}/>}/>
                            <Route path={"/accommodations/edit/:id"} element={
                                <AccommodationEdit categories={this.state.categories}
                                             hosts={this.state.hosts}
                                             onEditAccommodation={this.editAccommodation}
                                             accommodation={this.state.selectedAccommodation}/>}/>


                            <Route path="/" element={<Navigate replace to="/accommodations" />} />

                        </Routes>
                    </div>

                </main>
            </Router>

        </div>

    );
  }

  componentDidMount() {
    this.loadAccommodations();
    this.loadHosts();
    this.loadCategories();
  }

    loadAccommodations = () => {
        websiteService.fetchAccommodations()
            .then((data) =>{
                this.setState({
                    accommodations:data.data
                })

            })
    }
    loadCategories = () => {
        websiteService.fetchCategories()
            .then((data) =>{
                this.setState({
                    categories:data.data
                })

            })
    }
    loadHosts = () => {
        websiteService.fetchHosts()
            .then((data) =>{
                this.setState({
                    hosts:data.data
                })

            })
    }
    deleteAccommodation = (id) => {
      websiteService.deleteAccommodation(id)
          .then(() => {
              this.loadAccommodations();
          })
    }
    addAccommodation = (name, category, host, numRooms, isRented) => {
        websiteService.addAccommodation(name, category, host, numRooms, isRented)
            .then(() => {
                this.loadAccommodations();
            });
    }
    getAccommodation = (id) => {
        websiteService.getAccommodation(id)
            .then((data) => {
                this.setState({
                    selectedAccommodation: data.data
                })
            })
    }

    editAccommodation = (id, name, category, host, numRooms, isRented) => {
        websiteService.editAccommodation(id, name, category, host, numRooms, isRented)
            .then(() => {
                this.loadAccommodations();
            });
    }
    rentAccommodation = (id) => {
      websiteService.rentAccommodation(id)
          .then(() => {
              this.loadAccommodations();
          })
    }


}
export default App;

