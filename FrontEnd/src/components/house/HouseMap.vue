<template>
  <b-container class="test">
    <div id="map"></div>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
// import EventBus from "@/utils/eventBus";

export default {
  name: "HouseMap",
  data() {
    return {
      map: null,
      markers: [],
      houseMakers: [],
      latitude: 0,
      longitude: 0,
    };
  },
  computed: {
    ...mapState("houseStore", ["houses", "housesPosition"]),
  },
  watch: {
    houses: function () {
      this.initMap();
    },
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=35aa25f71212a7248e6f16d87f3d83d6";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
      this.displayMarker(this.housesPosition);
    },

    displayMarker(markerPositions) {
      if (this.houseMakers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
        this.houseMakers = [];
      }

      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.houseMarkers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
  },
};
</script>

<style scoped>
.test {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

#map {
  width: 95%;
  height: 90%;
  border: 1px #a8a8a8 solid;
}
</style>
