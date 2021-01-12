package com.implantaire.architectureflow.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "profile")
class ProfileModel {
    @SerializedName("login")
    @ColumnInfo(name ="login")
    @Expose
    var login: String? = null

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @Expose
    var id: Int? = null

    @SerializedName("node_id")
    @ColumnInfo(name = "node_id")
    @Expose
    var nodeId: String? = null

    @SerializedName("url")
    @ColumnInfo(name = "url")
    @Expose
    var url: String? = null

    @SerializedName("repos_url")
    @ColumnInfo(name = "repos_url")
    @Expose
    var reposUrl: String? = null

    @SerializedName("events_url")
    @ColumnInfo(name ="events_url")
    @Expose
    var eventsUrl: String? = null

    @SerializedName("hooks_url")
    @ColumnInfo(name ="hooks_url")
    @Expose
    var hooksUrl: String? = null

    @SerializedName("issues_url")
    @ColumnInfo(name ="issues_url")
    @Expose
    var issuesUrl: String? = null

    @SerializedName("members_url")
    @ColumnInfo(name ="members_url")
    @Expose
    var membersUrl: String? = null

    @SerializedName("public_members_url")
    @ColumnInfo(name ="public_members_url")
    @Expose
    var publicMembersUrl: String? = null

    @SerializedName("avatar_url")
    @ColumnInfo(name ="avatar_url")
    @Expose
    var avatarUrl: String? = null

    @SerializedName("description")
    @ColumnInfo(name ="description")
    @Expose
    var description: String? = null
}