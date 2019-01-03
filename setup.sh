#!/bin/bash
################################################################################
#   Project: Ermon
#
#   File: setup.sh
#
#   Description: Performs initial setup of Ermon project, consisting in:
#		- Check if required software is located in the system
#		- Perform a Continuous Integration (CI) iteration.
#		The script is automatic, and each phase is executed only
#		if previous one finish successfully.
#
#   Notes: N/A
#
#   Contact: Alberto Martin Cajal, amartin.glimpse23<AT>gmail.com
#
#   URL: https://github.com/amcajal/ermon
#
#   License: GNU GPL v3.0
#
#   Copyright (C) 2018,2019 Alberto Martin Cajal
#
#   This file is part of Ermon
#
#   Ermon is free software: you can redistribute it and/or modify
#   it under the terms of the GNU General Public License as published by
#   the Free Software Foundation, either version 3 of the License, or
#   (at your option) any later version.
#
#   Ermon is distributed in the hope that it will be useful,
#   but WITHOUT ANY WARRANTY; without even the implied warranty of
#   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#   GNU General Public License for more details.
#
#   You should have received a copy of the GNU General Public License
#   along with this program.  If not, see <http://www.gnu.org/licenses/>.
################################################################################

print_info_message()
{
	echo "\n\n##############################"
	echo "	$1"
	echo "##############################\n\n"
}

print_error_message()
{
	echo "##############################"
	echo "	A COMMAND HAS FAILED --->"
	echo "			$1"
	echo "##############################"
}


print_success_message()
{
	echo "##############################"
	echo "	ERMON SETUP FINISHED SUCCESSFULLY. APP READY TO GO!"
	echo "##############################"
}

################################################################################

print_info_message "Ermon Project SETUP script"

CURRENT_DIR=$(pwd)
SCRIPTS_DIR="./project/scripts"
LOG_ABSPATH=$(pwd)/setup_log.txt
rm setup_log.txt

cd $SCRIPTS_DIR

#CHECK FOR REQUIRED SOFTWARE
sh check_req_software.sh 2>&1 | tee -ai $LOG_ABSPATH

################################################################################
# ATTEMPT CONTINUOUS INTEGRATION (CI) EXECUTION
################################################################################
print_info_message "Running Continuous Integration (CI) script of Ermon..."

sh CI.sh 2>&1 | tee -ai $LOG_ABSPATH

if [ $? -ne 0 ]; then
    print_error_message "sh $SCRIPTS_DIR/CI.sh"
    exit 1
fi
###############################################################################
print_success_message
exit 0
