#!/bin/bash
parent_path=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
cd '/Users/atroush/.m2/repository/allure/allure-2.32.2/bin/'
bash allure serve $parent_path'/allure-results' -h localhost
exit