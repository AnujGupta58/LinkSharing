package com.ttn.linksharing.VO

class RatingInfoVO {
    Integer totalVotes, averageScore, totalScore

    String toString() {
        "${totalVotes} : ${averageScore} : ${totalScore}"
    }
}