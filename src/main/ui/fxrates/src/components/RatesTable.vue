<script lang="ts">

import RateComponent from './RateComponent.vue'

import { getRates, getCurrencies } from '../services/RatesService'

export default {
  name: 'RatesTable',
  components: { RateComponent },
  data() {
    return {
      ratesList: [],
      currencyList: [],
      ready: false
    }
  },
  methods: {
    getData(){
      getRates().then(response => {
        this.ratesList = response
        getCurrencies().then(response => {
          this.currencyList = response
          this.ready = true
        })
      })
    }
  },
  mounted() {
    this.getData()
  }
}

</script>

<template>
    <div v-if="ready" class="d-table ps-1">
        <RouterLink v-for="rate in ratesList" :key="rate.id" :to="{path: '/rate/' + rate.ccyTo}" >
          <RateComponent  :rate="rate" :currencies="currencyList" />
        </RouterLink>
    </div>
    <div v-else>
      Rates are updating at the moment
    </div>
</template>
