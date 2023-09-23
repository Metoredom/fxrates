<script lang="ts">
import { getRates, getCurrencies } from '../services/RatesService'

export default {
    name: 'CalculatorComponent',
    data() {
        return {
            ratesList: [],
            currencyList: [],
            ccy_from: 'EUR',
            ccy_to: 'USD',
            amount_from: 1,
            amount_to: 1,
            rate: 1
        }
    },
    methods: {
        getRates() {
            getRates().then((response) => {
                this.ratesList = response
                this.rate = this.ratesList.find(rate => rate.ccyFrom == this.ccy_from && rate.ccyTo == this.ccy_to).rate
                this.amount_to = this.rate
            })
        },
        getCurrencies() {
            getCurrencies().then((response) => {
                this.currencyList = response
            })
        },
        changedCcyTo() {
            if (this.ratesList.find(rate => rate.ccyFrom == this.ccy_from && rate.ccyTo == this.ccy_to))
                this.rate = this.ratesList.find(rate => rate.ccyFrom == this.ccy_from && rate.ccyTo == this.ccy_to).rate
            else
                this.rate = 0

            this.amount_to = this.amount_from * this.rate
        },
        changedAmountFrom() {
            this.amount_to = this.formatAmount(this.amount_from * this.rate)
        },
        changedAmountTo() {
            if (this.rate)
                this.amount_from = this.formatAmount(this.amount_to / this.rate)
        },
        formatAmount(value: number) {
            console.log(value)
            return parseFloat(new Intl.NumberFormat('en-EN', { maximumSignificantDigits: 5 }).format(value).replaceAll(',', ''))
        }
    },
    mounted() {
        this.getRates()
        this.getCurrencies()
    }
}
</script>


<template>
    <div class="card card-element" style="height: 90vh;">
        <div class="card-body">
            <form id="fxform" style="padding-top: 10vh;">
                <div class="row mb-4">
                    <div class="col text-center">
                        <picture>
                            <img src="/picture.jpg" width="400px">
                        </picture>
                    </div>
                </div>
                <div class="row mb-5">
                    <div class="col text-center">
                        <h2>Currency calculator</h2>
                    </div>
                </div>
                <div class="row align-items-center">
                    <div class="col-3 offset-2">
                        <select name="ccy_from" id="ccy_from" class="form-control form-select form-select-lg"
                            v-model="ccy_from" disabled>
                            <option v-for="ccy in currencyList" :key="ccy.id" :value="ccy.ccy">{{ ccy.name }} ({{ ccy.ccy
                            }})</option>
                        </select>
                    </div>
                    <div class="col-2 text-center rate-arrow">
                        <span class="h3"><i class="bi bi-arrow-left-right"></i></span>
                    </div>
                    <div class="col-3">
                        <select name="ccy_to" id="ccy_to" class="form-control form-select form-select-lg" v-model="ccy_to"
                            @change="changedCcyTo">
                            <option v-for="ccy in currencyList" :key="ccy.id" :value="ccy.ccy">{{ ccy.name }} ({{ ccy.ccy
                            }})</option>
                        </select>
                    </div>
                </div>
                <div class="row align-items-center mt-3">
                    <div class="col-3 offset-2">
                        <input type="text" id="amount_from" name="amount_from" v-model.number="amount_from"
                            class="form-control form-control-lg" @change="changedAmountFrom">
                    </div>
                    <div class="col-2 text-center">
                        <span class="text-muted fs-6">{{ rate }}</span>
                    </div>
                    <div class="col-3">
                        <input type="text" id="amount_to" name="amount_to" v-model.number="amount_to"
                            class="form-control form-control-lg" @change="changedAmountTo">
                    </div>
            </div>
        </form>
    </div>
</div></template>