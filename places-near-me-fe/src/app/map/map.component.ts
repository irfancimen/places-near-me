import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { PlaceService } from "../service/place.service";

@Component({
    selector: 'map-component',
    templateUrl: './map.component.html',
    styleUrls: ['./map.component.less']
  })
export class MapComponent implements OnInit{

    public lat: any = 41.0393994;
    public lng: any = 28.99192;
    public zoom: number = 12;
    public markers: any = [];
    public submmited: boolean = false;
    public isLoading: boolean = false;
    
    searchForm: FormGroup = new FormGroup({
        lat: new FormControl('', Validators.required),
        lng: new FormControl('', Validators.required),
        radius: new FormControl('', Validators.required)
    })

    constructor(private placeService: PlaceService) {

    }

    ngOnInit(): void {
        this.setCurrentLocation();
    }

    get f() {
        return this.searchForm.controls;
      }

    private setCurrentLocation() {
        if ('geolocation' in navigator) {
            navigator.geolocation.getCurrentPosition((position) => {
                this.lat = position.coords.latitude;
                this.lng = position.coords.longitude;
                this.zoom = 17;
            });
        }
    }

    public onSubmit() {
        this.submmited = true;
        if (this.searchForm.invalid) {
            return;
        }
        const {lat, lng, radius} = this.searchForm.value;
        const params = {
            lat: lat,
            lng: lng,
            radius: radius,
        }
        this.placeService.getNearbyPlaces(params).subscribe(response => {
            if (response) {
                this.markers = response;
                this.lat = Number(lat);
                this.lng = Number(lng);
                this.zoom = 16;
                this.isLoading = true;
            }
        }, err => {
            this.isLoading = false;
            window.alert(err.error);
        })
    }

}