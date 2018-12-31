#!/bin/bash
################################################################################
#   Project: Ermon
#
#   File: CI.sh
#
#   Description: Performs a Continuous Integration (CI) in the local
#		computer (full build, testing and deployment cycle).
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
	echo "	Ermon Project: Continuous Integration finished successfully!"
	echo "##############################"
}

###############################################################################
print_info_message "Ermon Continuous Integration"

SCRIPTS_DIR=$(pwd)
INTEGRATION_DIR=../dev/integration/

#Currently, the script is very simple, as it just launches Ant to build the application.

print_info_message "Building application..."
cd $INTEGRATION_DIR
ant

if [ $? -ne 0 ]; then
	print_error_message "ant build at $INTEGRATION_DIR"
	exit 1
fi

###############################################################################

print_success_message
exit 0
