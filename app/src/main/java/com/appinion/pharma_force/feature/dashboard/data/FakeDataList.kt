package com.appinion.pharma_force.feature.dashboard.data

import com.appinion.pharma_force.R

object FakeDataList {
     var fakeList = ArrayList<DashBoardModel>()

    open fun getFakeDataList(): List<DashBoardModel>{
        fakeList = ArrayList<DashBoardModel>()
        fakeList.add(
            DashBoardModel(
                R.drawable.pills,
                "Medicine Literature",
                "Product Detailing Point, Full Book, Ft. & Benefit, Call Product Manager",
                9
            )
        )
        fakeList.add(
            DashBoardModel(
                R.drawable.mail,
                "Communication Hub",
                "View Important Messages from Admin, Product Managers etc.",
                3
            )
        )
        fakeList.add(
            DashBoardModel(
                R.drawable.medical_team,
                "DCR & CRF",
                "Doctor Call Record & Call Rec. Forwarding: Add New Doctor/ Intern, Doctor Visit Schedule",

            )
        )

        fakeList.add(
            DashBoardModel(
                R.drawable.prescription_rx,
                "Rx Calculator",
                "Submit Prescription Online, Save Prescription Offline, View History",

            )
        )

        fakeList.add(
            DashBoardModel(
                R.drawable.profits,
                "Incentive Tracker",
                "Quarterly/ Yearly Sales Target & Achievements, Estimated Incentive Earned in Amount",

            )
        )

        fakeList.add(
            DashBoardModel(
                R.drawable.exam,
                "Test Center",
                "Participate in Mandatory/ Optional MCQ Tests, Earn Points, View Test Result",
                6
            )
        )

        fakeList.add(
            DashBoardModel(
                R.drawable.giftbox,
                "Renata Shop",
                "Redeem Exiting Gifts by Using Points Earned from Test Center",
                1
            )
        )

        fakeList.add(
            DashBoardModel(
                R.drawable.award,
                "Leader Board",
                "View Monthly Top Performer Based on Knowledge Based Evaluation",

            )
        )


        return fakeList
    }
}