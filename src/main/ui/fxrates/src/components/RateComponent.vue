<script setup lang="ts">

import { formatDate } from './utils'

defineProps<{
  rate: object,
  currencies: object
}>()
</script>

<template>
  <div class="card mb-2 rate-card card-element ">
    <div class="card-body">
      <div class="row align-items-center">
        <div class="row mb-1 align-items-center">
          <div class="col-4">
            <span class="card-title">{{ currencies.filter(currency => currency.ccy == rate.ccyFrom)[0].name }} ({{
              rate.ccyFrom }})</span>
          </div>
          <div class="col-2 h5 rate-arrow">
            <i class="bi bi-arrow-left-right"></i>
          </div>
          <div class="col-6">
            <span class="card-title">{{ currencies.filter(currency => currency.ccy == rate.ccyTo)[0].name }} ({{
              rate.ccyTo }})</span>
          </div>
        </div>
        <div class="row align-items-center">
          <div class="col-6">
            <span class="card-title h2">{{ rate.rate }}</span>
          </div>
          <div class="col-6">
            <span class="card-subtitle text-muted"> at {{ formatDate(rate.date) }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
