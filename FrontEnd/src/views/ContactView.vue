<template>
  <b-container>
    <b-container style="padding: 0px">
      <b-jumbotron style="margin-top: 10px; background-color: white">
        <div class="text-center head-title">Contact Us</div>
      </b-jumbotron>
    </b-container>
    <div class="contact-form mx-auto">
      <form ref="form" @submit.prevent="sendEmail">
        <b-form-group id="input-group-2" label="Your ID:" label-for="input-1">
          <b-form-input
            name="id"
            v-model="id"
            placeholder="Enter ID"
            class="input-font"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group label="Email address:" label-for="input-2">
          <b-form-input
            name="email"
            v-model="email"
            type="email"
            placeholder="Enter email"
            class="input-font"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group label="Message" label-for="input-3">
          <b-form-textarea
            name="message"
            placeholder="내용을 입력하세요..."
            v-model="message"
            rows="8"
            class="input-font"
            required
          ></b-form-textarea>
        </b-form-group>
        <b-button class="form-button" type="submit" variant="success"
          >등 록</b-button
        >
      </form>
    </div>
  </b-container>
</template>

<script>
import Swal from "sweetalert2";
import emailjs from "@emailjs/browser";

export default {
  name: "ContactView",
  data() {
    return {
      id: "",
      email: "",
      message: "",
    };
  },
  methods: {
    sendEmail() {
      emailjs
        .sendForm(
          "service_rgscg6t",
          "template_1w4hu1q",
          this.$refs.form,
          "amz4F9Q-eOe6qvsvV"
        )
        .then(
          (result) => {
            console.log("SUCCESS!", result.text);
            Swal.fire({
              position: "center",
              icon: "success",
              width: 350,
              title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">등록 완료<div>`,
              showConfirmButton: false,
              timer: 1500,
            });
            this.sendHome();
          },
          (error) => {
            console.log("FAILED...", error.text);
            Swal.fire({
              position: "center",
              icon: "error",
              width: 350,
              title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">다시 시도 바랍니다.<div>`,
              showConfirmButton: false,
              timer: 1500,
            });
          }
        );
    },
    onReset() {
      this.name = "";
      this.email = "";
      this.message = "";
    },
    sendHome() {
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
.contact-form {
  margin: auto;
  padding: 0 60px;
  max-width: 600px;
  font-size: 14px;
}

.form-button {
  margin-right: 10px;
  width: 100px;
}

.head-title {
  font-size: 50px;
  font-weight: 800;
}

.input-font {
  font-size: 14px;
}
</style>
