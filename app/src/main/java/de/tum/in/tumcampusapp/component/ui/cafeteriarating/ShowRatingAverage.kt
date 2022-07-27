package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating

class ShowRatingAverage {
    var img = false
    var points = 1
    var comment = ""
    lateinit var RatingTagsResults: List<ShowTagRatingAverage>
    lateinit var NameTagsResults: List<ShowTagRatingAverage>

    constructor(
        img: Boolean,
        points: Int,
        comment: String,
        RatingTagsResults: List<ShowTagRatingAverage>,
        NameTagsResults: List<ShowTagRatingAverage>
    ) {
        this.img = img
        this.points = points
        this.comment = comment
        this.RatingTagsResults = RatingTagsResults
        this.NameTagsResults = NameTagsResults
    }
}