#!/bin/bash
################################################################################
#   Project: Ermon
#
#   File: check_req_software.sh
#
#   Description: Script to verify that required software to build Ermon app
#		is located in the system (with proper version, when required).
#
#   Notes: N/A
#
#   Contact: Alberto Martin Cajal, amartin.glimpse23<AT>gmail.com
#
#   URL: https://github.com/amcajal/ermon
#
#   License: GNU GPL v3.0
#
#   Copyright (C) 2018 Alberto Martin Cajal
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
###############################################################################

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
	echo "	Ermon project: Check_required_software finished sucessfully!"
	echo "##############################"
}

###############################################################################
print_info_message "Ermon Project: Checking required software..."

#Java
print_info_message "Checking for Java..."
java -version
if [ $? -ne 0 ]; then
	print_error_message "Java not found. Aborting..."
	exit 1
fi

#Ant
print_info_message "Checking for Ant..."
ant -version
if [ $? -ne 0 ]; then
	print_error_message "Ant not found. Aborting..."
	exit 1
fi

###############################################################################
print_success_message
exit 0
