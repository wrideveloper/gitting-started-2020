const puppeteer = require("puppeteer");
const BASE_URL = "https://tx3.asia.travian.com/";
const random = require("random");
const moment = require("moment");
const low = require("lowdb");
const FileSync = require("lowdb/adapters/FileSync");
const adapter = new FileSync("newdb.json");
const db = low(adapter);
