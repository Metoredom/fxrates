<script lang="ts">
import RateChart from '@/components/RateChart.vue'
import { getHistory } from '../services/RatesService'
import RouterLink from 'vue-router'
import { formatDate } from '../components/utils'

export default {
    name: "RateView",
    components: { RateChart },
    data() {
        return {
            historyList: [],
            chart: false
        }
    },
    methods: {
        getHistory() {
            getHistory(this.$route.params.ccy).then((response) => {
                this.historyList = response
                this.chart = true
            })
        },
        formatDate(value: string) {
            return formatDate(value)
        }
    },
    mounted() {
        this.getHistory()
    }
}

</script>

<template>
    <main class="pt-5">
        <div class="card card-element">
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        <h4>History for {{ $route.params.ccy }}</h4>
                    </div>
                    <div class="col text-end">
                        <RouterLink to="/"><button type="button" class="btn btn-close"></button></RouterLink>
                    </div>
                </div>
                <div class="row" style="height: 500px;">
                    <div class="col">
                        <RateChart v-if="chart" :data="historyList" />
                    </div>
                </div>
                <div class="row p-5">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Rate</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="rate in historyList" :key="rate.id">
                                <td>{{ rate.rate }}</td>
                                <td>{{ formatDate(rate.date) }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>
</template>